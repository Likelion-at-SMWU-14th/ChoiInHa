from rest_framework import generics, permissions, status, viewsets
from rest_framework.response import Response

from .models import Post
from .permissions import IsAuthorOrReadOnly
from .serializers import PostSerializer, SignUpSerializer


class SignUpAPIView(generics.CreateAPIView):
    serializer_class = SignUpSerializer
    permission_classes = [permissions.AllowAny]

    def create(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.save()
        return Response(
            {
                'message': '회원가입이 완료되었습니다.',
                'user': SignUpSerializer(user).data,
            },
            status=status.HTTP_201_CREATED,
        )


class PostListCreateAPIView(generics.ListCreateAPIView):
    queryset = Post.objects.select_related('author').all()
    serializer_class = PostSerializer

    def get_permissions(self):
        if self.request.method == 'POST':
            return [permissions.IsAuthenticated()]
        return [permissions.AllowAny()]

    def perform_create(self, serializer):
        serializer.save(author=self.request.user)


class PostRetrieveDestroyAPIView(generics.RetrieveDestroyAPIView):
    queryset = Post.objects.select_related('author').all()
    serializer_class = PostSerializer
    permission_classes = [IsAuthorOrReadOnly]

    def get_permissions(self):
        if self.request.method == 'DELETE':
            return [permissions.IsAuthenticated(), IsAuthorOrReadOnly()]
        return [permissions.AllowAny()]


class PostViewSet(viewsets.ModelViewSet):
    queryset = Post.objects.select_related('author').all()
    serializer_class = PostSerializer
    permission_classes = [IsAuthorOrReadOnly]

    def get_permissions(self):
        if self.action in ['create', 'update', 'partial_update', 'destroy']:
            return [permissions.IsAuthenticated(), IsAuthorOrReadOnly()]
        return [permissions.AllowAny()]

    def perform_create(self, serializer):
        serializer.save(author=self.request.user)
