package sample;

import org.eclipse.paho.client.mqttv3.*;

import java.util.Scanner;

/**
 * Created by ali on 11/28/16.
 */

/**
 * https://www.thethingsnetwork.org/docs/current/mqtt/
 * https://mosquitto.org/man/mosquitto_sub-1.html
 *  -t, --topic
    The MQTT topic to subscribe to. See mqtt(7) for more information on MQTT topics.
    This option may be repeated to subscribe to multiple topics.

 *  -u, --username
    Provide a username to be used for authenticating with the broker.
    This requires a broker that supports MQTT v3.1. See also the --pw argument.

 *  -P, --pw
    Provide a password to be used for authenticating with the broker.
    Using this argument without also specifying a username is invalid.
    This requires a broker that supports MQTT v3.1. See also the --username option.


 *  -v, --verbose
    Print received messages verbosely.
    With this argument, messages will be printed as "topic payload".
    When this argument is not given, the messages are printed as "payload".
 */






public class PahoMqttClient implements MqttCallback {
    private MqttClient client;
    //forTTN
    public PahoMqttClient(String serverURI, String clientID, String appEUI, String appAccessKey){
        try {
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setUserName(appEUI);
            connectOptions.setPassword(appAccessKey.toCharArray());
            client = new MqttClient(serverURI, clientID);
            client.connect();
        }catch (MqttException e){
            e.printStackTrace();
        }
    }
    //normal mqtt server
    public PahoMqttClient(String serverURI, String clientID){
        try {
            client = new MqttClient(serverURI, clientID);
            client.connect();
        }catch (MqttException e){
            e.printStackTrace();
        }
    }


    public void publish(String topic, String data){
        /**
         * Topic: Down (Send)

         To send a message to a specific device registered to the application, publish to:
         +/devices/<DeviceEUI>/down

         Or, in this case maybe more clear:
         <AppEUI>/devices/<DeviceEUI>/down

         Message format
         Encoded as JSON string, format your message as:

         {
         "payload": "SGVsbG8gd29ybGQK=",
         "port": 1,
         "ttl": "1h"
         }
         */
        MqttMessage message = new MqttMessage();
        message.setPayload(data.getBytes());
        try {
            client.publish(topic,message);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }




    public void subscribe(String topic){

        /**
         * Topic: Up (Receive)

         To receive messages from all devices registered to the application, subscribe to:
         <AppEUI>/devices/+/up

         Or, since the authentication already limits you to an Application:
         +/devices/+/up

         To get messages for a specific device subscribe to:
         +/devices/<DeviceEUI>/up

         Or if you like to be verbose:
         <AppEUI>/devices/<DeviceEUI>/up
         */

        try {
            client.setCallback(this);
            client.subscribe(topic);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }


    public void disconnect(){
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void reconnect(){
        try {
            client.reconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void connectionLost(Throwable throwable) {

    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage);


    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    public String receiveNttTopic(){
        return "+/devices/+/up";
    }

    public String sendNttTopic(){
        return "+/devices/<DeviceEUI>/down";
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Topic: ");
        String topic = scan.nextLine();
        System.out.println("Data: ");
        String data = scan.nextLine();
        PahoMqttClient client = new PahoMqttClient("tcp://localhost:1883","Beerus-sama");
        client.subscribe(topic);
        client.publish(topic,data);
    }
}
