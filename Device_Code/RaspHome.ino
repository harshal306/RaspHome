int relay = D1;
int boardLed = D7;
bool vin = LOW;

// setup() is run only once, it's where we set up GPIO and initialise peripherals
void setup() {
    
  // Setup GPIO
  pinMode(relay,OUTPUT); // relay pin is set as output
  digitalWrite(relay,LOW);
  
  Particle.subscribe("Your_Event_Name", myHandler); //turning off function declaration
  Particle.subscribe("Your_Event_Name", thisHandler); //turning on function declaration
  
}

// loop() runs continuously, it's our infinite loop.
void loop() {
     if (vin==HIGH)
     {
         digitalWrite(relay,LOW);
     }
else if (vin==LOW)
      {
         digitalWrite(relay,HIGH);
     }

}

void myHandler(const char *event, const char *data)
{   
        vin=LOW;
}
    

void thisHandler(const char *event, const char *data)
{   
        vin=HIGH;
}

void alreadyGlowing(const char *event, const char *data){   
    
    if (vin == LOW){
        
        vin = LOW;
    }
    else {
        
        vin = HIGH;
    }
    
    
}

void alreadyClosed(const char *event, const char *data){
    
    vin = HIGH;
    
}