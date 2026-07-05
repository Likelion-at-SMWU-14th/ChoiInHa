from django.contrib.auth import get_user_model
from django.urls import reverse
from rest_framework import status
from rest_framework.test import APITestCase

from .models import Post

User = get_user_model()


class BlogAPITestCase(APITestCase):
    def test_signup_creates_user(self):
        response = self.client.post(
            reverse('signup'),
            {
                'username': 'blogger',
                'password': 'strong-password-123',
                'email': 'blogger@example.com',
            },
            format='json',
        )

        self.assertEqual(response.status_code, status.HTTP_201_CREATED)
        self.assertTrue(User.objects.filter(username='blogger').exists())

    def test_authenticated_user_can_create_post(self):
        user = User.objects.create_user(username='writer', password='password12345')
        self.client.force_authenticate(user=user)

        response = self.client.post(
            reverse('post-list-create'),
            {'title': '첫 번째 글', 'content': '나만의 블로그 글입니다.'},
            format='json',
        )

        self.assertEqual(response.status_code, status.HTTP_201_CREATED)
        self.assertEqual(Post.objects.get().author, user)

    def test_anonymous_user_cannot_create_post(self):
        response = self.client.post(
            reverse('post-list-create'),
            {'title': '익명 글', 'content': '로그인 없이 작성합니다.'},
            format='json',
        )

        self.assertEqual(response.status_code, status.HTTP_401_UNAUTHORIZED)
