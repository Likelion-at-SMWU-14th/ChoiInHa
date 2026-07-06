from django.contrib import admin
from django.urls import include, path
from rest_framework_simplejwt.views import TokenObtainPairView, TokenRefreshView

from posts.views import SignUpAPIView

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/users/signup/', SignUpAPIView.as_view(), name='signup'),
    path('api/users/login/', TokenObtainPairView.as_view(), name='token_obtain_pair'),
    path('api/users/token/refresh/', TokenRefreshView.as_view(), name='token_refresh'),
    path('api/', include('posts.urls')),
]
