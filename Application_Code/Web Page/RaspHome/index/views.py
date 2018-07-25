from django.shortcuts import render
from django.http import HttpResponse
from django.http import HttpResponseRedirect

from .forms import LoginForm
import json
import requests



def index(request):
    if request.session.has_key('email') and request.session.has_key('api'):
        print ("SOme true")
        return render(request, 'RaspHome/login_action.html', {"Credentials": [request.session['email'], request.session['api']]})
    else:
        return render(request, "RaspHome/index.html")

def login(request):
    email = ""
    pswd = ""
    if request.session.has_key('email') and request.session.has_key('api'):
        print ("SOme true")
        return render(request, 'RaspHome/login_action.html', {"Credentials": [request.session['email'], request.session['api']]})
    else:
        print ("false")
        if request.method == "POST":
            form = LoginForm(request.POST)

            if form.is_valid():
                email = form.cleaned_data['email']
                pswd = form.cleaned_data['pswd']
                request.session['email'] = email
                request.session['pswd'] = pswd

        else:
            form = LoginForm()
        
        if isValid(email,pswd):
            url = "https://api.particle.io/v1/access_tokens?"

            querystring = {email+":"+pswd:""}

            headers = {
                'Authorization': "Basic aHJzaGxtaXR0YWwzMDZAZ21haWwuY29tOjEyMzQ1Njc4OQ==",
                'Cache-Control': "no-cache",
                'Postman-Token': "a29b1f88-a1e8-4792-9cba-7b7ffaadc805"
                }
            try:
                api_lis = []
                response = requests.request("GET", url, headers=headers, params=querystring)
                dic = json.loads(response.text)
                for i in range(len(dic)):
                    for item in dic[i]:
                        if item == "token":
                            api_lis.append((dic[i][item]))
                print (api_lis)
                request.session['api'] = api_lis[0]
            except Exception as e:
                return HttpResponse("<h1 align='center'>Slow or No Internet Connection</h1><br/><br/><p align='center'>Please try Again</p>")

            return render(request, 'RaspHome/login_action.html', {"Credentials": [email,api_lis[0]]})
        else:
            return render(request, 'RaspHome/index.html', {"Credentials": "Wrong Email or Password. try Again"})        

    
        
def isValid(email,pswd):

    if email == "hrshlmittal306@gmail.com" and pswd == "123456789":
        return True
    else:
        return False

def logout(request):
    try:
        del request.session['email']
        del request.session['pswd']
        del request.session['api']
    except Exception as e:
        pass
        
    return render(request,"RaspHome/index.html")
