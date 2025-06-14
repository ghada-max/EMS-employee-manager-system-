#!/bin/bash

echo "Déploiement des microservices en cours..."

echo "building employee image ..."
docker build -t employeeapp:latest ./Employeeproject

echo "building eureka image ..."
docker build -t discovery-server:latest ./DiscoveryServer

echo "building department image ..."
docker build -t department:latest ./departmentProject

echo "building attendance image ..."
docker build -t attendance:latest ./attendanceproject

echo "building leave image ..."
docker build -t leave:latest ./Leaveproject

echo "building payroll image ..."
docker build -t payroll:latest ./payroll-project

echo "building bankConsumer image ..."
docker build -t bankconsumer:latest ./bankConsumer

echo "building deduction image ..."
docker build -t deduction:latest ./deduction


echo "deploying kafka"
kubectl apply -f Kubernetes/kafka/kafka-pvc.yaml
kubectl apply -f Kubernetes/kafka/kafka-deployment.yaml
kubectl apply -f Kubernetes/kafka/kafka-service.yaml


echo "deploying zookeeper"
kubectl apply -f Kubernetes/zookeeper/zookeeper-pvc.yaml
kubectl apply -f Kubernetes/zookeeper/zookeeper-deployment.yaml
kubectl apply -f Kubernetes/zookeeper/zookeeper-service.yaml


echo "deploying MYSQL"
kubectl apply -f Kubernetes/mysql/mysql-pvc.yaml
kubectl apply -f Kubernetes/mysql/mysql-deployment.yaml
kubectl apply -f Kubernetes/mysql/mysql-service.yaml

echo "deploying phpmyadmin"
kubectl apply -f Kubernetes/phpmyadmin/phpmyadmin-deployment.yaml
kubectl apply -f Kubernetes/phpmyadmin/phpmyadmin-service.yaml

echo "deploying employeeapp"
kubectl apply -f Kubernetes/employee/employeeapp-deployment.yaml
kubectl apply -f Kubernetes/employee/employeeapp-service.yaml

echo "deploying eureka"
kubectl apply -f Kubernetes/eureka/eureka-deployment.yaml
kubectl apply -f Kubernetes/eureka/eureka-service.yaml

echo "deploying leaves-app"
kubectl apply -f Kubernetes/leaves/leaves-deployment.yaml
kubectl apply -f Kubernetes/leaves/leaves-service.yaml

echo "deploying attendances-app"
kubectl apply -f Kubernetes/attendances/attendanceapp-deployment.yaml
kubectl apply -f Kubernetes/attendances/attendanceapp-service.yaml

echo "deploying department-app"
kubectl apply -f Kubernetes/department/departmentapp-deployment.yaml
kubectl apply -f Kubernetes/department/departmentapp-service.yaml

echo "deploying deduction-app"
kubectl apply -f Kubernetes/deduction/deductionapp-deployment.yaml
kubectl apply -f Kubernetes/deduction/deductionapp-service.yaml

echo "deploying bankConsumer-app"
kubectl apply -f Kubernetes/bankConsumer/bankConsumerapp-deployment.yaml
kubectl apply -f Kubernetes/bankConsumer/bankConsumerapp-service.yaml

echo "deploying payroll-app"
kubectl apply -f Kubernetes/payroll/payrollapp-deployment.yaml
kubectl apply -f Kubernetes/payroll/payrollapp-service.yaml
