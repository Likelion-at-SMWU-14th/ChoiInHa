from django.urls import path
from . import views
from .views import MemoDetailView

app_name = 'memo'

urlpatterns = [
    path('', views.memo_list, name='memo_list'),
    path('<int:pk>/', MemoDetailView.as_view(), name='memo_detail'),
]