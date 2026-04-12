from django.db import models

# Create your models here.
class Image(models.Model):
    image = models.ImageField(verbose_name='이미지')
    content = models.TextField(verbose_name='내용')
    created_at = models.DateTimeField(verbose_name='작성일', auto_now_add=True)