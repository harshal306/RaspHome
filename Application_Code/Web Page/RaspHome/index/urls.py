from django.conf.urls import url
from . import views
from django.views.generic import TemplateView

urlpatterns = [
    url(r'^$', views.index, name='index'),
    #url(r'^$', TemplateView.as_view(template_name = 'RaspHome/index.html')),
    url(r'^login_action$', views.login, name='login'),
	url(r'^logout_action$', views.logout, name='login')]
