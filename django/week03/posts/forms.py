from django import forms
from .models import Post, Comment

class PostBasedForm(forms.Form):
    image = forms.ImageField()
    content = forms.CharField(min_length=5)


class PostModelForm(forms.ModelForm):
    class Meta:
        model = Post
        fields = ['image', 'content']

class CommentForm(forms.ModelForm):
    class Meta:
        model = Comment
        fields = ['content']