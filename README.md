# *RaspHome*
> RaspHome is a device that is developed to control the home Appliances using voice commands from anywhere in the world.

## Requirements

* Raspberry Pi 3 Model B
* Micro SD Card Raspberian OS (or any other Linux Distribution) installed
* Channel Relay (either 2,4,8 depending on your choice and requirement)
* Particle Cloud Registration
* Jumper Wires and other Guage Wires.
* Appliance (eg. Bulb or Fan)
* 5V Power Supply

## Installation

#### 1. Particle Setup

```
    $ bash <( curl -sL https://particle.io/install-pi ) 
    $ source env/bin/activate
    $ python -m googlesamples.assistant.grpc.pushtotalk --project-id Your_Project_ID
```
For resgistering the model visit [here](console.actions.google.com)
Write this code in raspberry pi OS Terminal and click Enter!
This will ask you to sign in to the particle account to access cloud.

#### 2. LogIn to the particle Account and Access the device Registered and *Build the Application*.

Build the Application by copying and exceuting the code in Device_App_code.ino through the build.particle.io
  
#### 3. Circuiting and Wiring

Refer to the Device Connection page in the repository ![](https://www.iotgadgets.com/wp-content/uploads/2018/02/GoogleAI_Pi-1068x759.png)
  
## Dependencies

#### 1. Through IFTTT

Download IFTTT App and Create New Applet and Select Google Assistant for If condition and Particle API for Then Condition
put your subscribe element name in the Publish Event console.

#### 2. Through Web page

Check out the HTML page in this repository and change the Access_token to your original access token for particle cloud and execute it to control the respective applicance.
  
#### 3. Self-Developed App RaspHome

Download the App RaspHome From PlayStore and put the login Credentials into it and give your Access token and exeucte to control the appliances through Voice commands From any where in the world.

## Execution

#### 1. Control your Appliance by Google Assistant through IFTTT
Just ask what you have written in the IFTTT "if" phrase. "then" phrase automaically be executed.

#### 2. Control your Appliance by RaspHome Web Page
visit [This page](https://github.com/harshal306/RaspHome/tree/master/Application_Code/Web%20Page/RaspHome_Controller.html) 
(make sure to enter your Access_Token and Event name)

#### 3. Control your Appliance by RaspHome Android App.

Work under Construction. would be available before 20th July 2018.

## To Contribute

Clone the repository make your neccesary changes and push into a new branch.
```
$ git clone https://github.com/harshal306/RaspHome
```
Make Required Changes in the local Repository and then
```
$ git checkout -b <name_of_branch>
$ git checkout <name_of_branch>
$ git push origin <name_of_branch>
```

## Developers and Contributors

1. [Harshal Mittal](www.linkedin.com/in/harshal306)
2. [Vasundhara Raje](https://www.linkedin.com/in/vasundhara-raje-237a4914b/)
