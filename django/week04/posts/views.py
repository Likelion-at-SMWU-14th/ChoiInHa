from rest_framework.viewsets import ModelViewSet
from django.contrib.auth import get_user_model
from django.shortcuts import get_object_or_404
from rest_framework import status
from rest_framework.decorators import api_view
from rest_framework.response import Response

from .models import Post
from .serializers import PostModelSerializer, UserModelSerializer

User = get_user_model()


class PostModelViewSet(ModelViewSet):
    queryset = Post.objects.all()
    serializer_class = PostModelSerializer


@api_view(['POST'])
def signup(request):
    serializer = UserModelSerializer(data=request.data)

    if serializer.is_valid():
        user = serializer.save()
        return Response(UserModelSerializer(user).data, status=status.HTTP_201_CREATED)

    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'PATCH', 'DELETE'])
def user_detail(request, user_id):
    user = get_object_or_404(User, id=user_id)

    if request.method == 'GET':
        serializer = UserModelSerializer(user)
        return Response(serializer.data)

    if request.method in ['PUT', 'PATCH']:
        serializer = UserModelSerializer(
            user,
            data=request.data,
            partial=request.method == 'PATCH',
        )

        if serializer.is_valid():
            user = serializer.save()
            return Response(UserModelSerializer(user).data)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    user.delete()
    return Response({'message': '회원 탈퇴가 완료되었습니다.'}, status=status.HTTP_200_OK)
