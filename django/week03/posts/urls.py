from django.urls import path
from .views import post_form_view, post_list_view, post_model_form_view, post_detail_view, post_update_view, post_delete_view, comment_create, comment_update

app_name = 'posts'

urlpatterns = [
    path('', post_list_view, name='post-list'),
    path('form/', post_form_view, name='post-form'),
    path('modelform/', post_model_form_view, name='post-model-form'),
    path('<int:id>/', post_detail_view, name='post-detail'),
    path('<int:id>/update/', post_update_view, name='post-update'),
    path('<int:id>/delete/', post_delete_view, name='post-delete'),
    path('<int:post_id>/', post_detail_view, name='post_detail'),
    path('<int:post_id>/comments/create/', comment_create, name='comment_create'),
    path('comments/<int:comment_id>/update/', comment_update, name='comment_update'),


]