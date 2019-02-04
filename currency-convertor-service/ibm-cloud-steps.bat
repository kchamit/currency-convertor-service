#build it creates the docker image and pushed to registry
#very cloud specific step
ibmcloud cr build -t registry.ng.bluemix.net/amitns/eureka-server:1 .

# create a deployement
# this will push the image to container
kubectl run eureka-server-deployment --image=registry.ng.bluemix.net/amitns/eureka-server:1

kubectl expose deployment/eureka-server-deployment --type=NodePort --port=8761 --name=eureka-service --target-port=8761


#build it creates the docker image and pushed to registry
#very cloud specific step
ibmcloud cr build -t registry.ng.bluemix.net/amitns/current-conversion-factor-data-service:2 .

# create a deployement
# this will push the image to container
kubectl run current-conversion-factor-data-service-deployment --image=registry.ng.bluemix.net/amitns/current-conversion-factor-data-service:2

#Not Now
kubectl expose deployment/current-conversion-factor-data-service-deployment --type=NodePort --port=8040 --name=current-conversion-factor-data-service --target-port=8040


#build it creates the docker image and pushed to registry
#very cloud specific step
ibmcloud cr build -t registry.ng.bluemix.net/amitns/convertor-service:1 .

# create a deployement
# this will push the image to container
kubectl run convertor-service-deployment --image=registry.ng.bluemix.net/amitns/convertor-service:1

kubectl expose deployment/convertor-service-deployment --type=NodePort --port=8050 --name=convertor-service --target-port=8050

