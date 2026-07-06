from django.urls import include, path
from rest_framework.routers import DefaultRouter

from .views import PostListCreateAPIView, PostRetrieveDestroyAPIView, PostViewSet

router = DefaultRouter()
router.register('viewset/posts', PostViewSet, basename='viewset-post')

urlpatterns = [
    path('posts/', PostListCreateAPIView.as_view(), name='post-list-create'),
    path('posts/<int:pk>/', PostRetrieveDestroyAPIView.as_view(), name='post-detail-delete'),
    path('', include(router.urls)),
]
