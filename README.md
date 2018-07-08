# *RaspHome*
> RaspHome is a device that is developed for controlling the home Appliances using voice commands from anywhere in the world.

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
	bash <( curl -sL https://particle.io/install-pi ) 
    $ source env/bin/activate
    $ python -m googlesamples.assistant.grpc.pushtotalk --project-id Your_Project_ID
```
For resgistering the model visit [here](console.actions.google.com)
<p> Write this code in raspberry pi OS Terminal and click Enter!
This is ask you to sign in to the particle account to access cloud.<p>

#### 2. LogIn to the particle Account and Access the device Registered and *Build the Application*.

<p>  Build the Application by copying and exceuting the code in Device_App_code.ino through the build.particle.io <p>
  
#### 3. Circuiting and Wiring

<p> Refer to the Circuit_diagram page <p>
  
## Execution

#### 1. Through IFTTT

<p> Download IFTTT App and Create New Applet and Select Google Assistant for If condition and Particle API for Then Condition
  put your subscribe element name in the Publish Event console. <p>

#### 2. Through Web page

<p> Check out the HTML page in this repository and change the Access_token to your original access token for particle cloud and execute it to control the respective applicance <p>
  
#### 3. Self-Developed App RaspHome

<p> Download the App RaspHome From PlayStore and put the login Credentials into it and give your Access token and exeucte to control the appliances through Voice commands From any where in the world.
  
## To Contribute

Clone the repository make your neccesary changes and push into a new branch.

## Developers and Contributors

1. [Harshal Mittal](www.linkedin.com/in/harshal306)
2. [Vasundhara Raje](https://www.linkedin.com/in/vasundhara-raje-237a4914b/)
