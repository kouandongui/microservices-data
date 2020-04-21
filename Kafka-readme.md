## INSTALLATION ET ADMINISTRATION DE KAFKA
L'éssentiel pour la manipulation de Kafka en formation data

##  Kakfa Pré-requis  File system
Contrôler le montage des disques en xfs ou en ext4 avec l'option noatime pour les data de kafka
Cette option désactive la mise à jour des dates d'accès et de modification de tous les fichiers sur la partition concernée par l'option.
Il s'agit de montage de file système de Kafka exemple var/log/kafka , var/log/zookeeper

##  Kakfa Pré-requis system:
Fixer dans /etc/sysctl.conf
ulimit -n 100000
vm.swappiness=1
vm.dirty_background_ratio=5 (Default: 10)
vm.dirty_ratio=60 (Default: 20) 

vm.swappiness=1
line: vm.dirty_background_ratio=5
line: vm.dirty_ratio=60
Charger: sysctl --system



## Répertoire et fichiers utiles 

* Répertoire des commandes:  confluent-5.3.2/bin
* Répertoire des fichiers de configuration:  confluent-5.3.2/etc/kafka ou /etc/kafka
* Fichier de configuration de zookeeper: /etc/kafka/zookeeper.properties
* Fichier de configuration de kafka: /etc/kafka/server.properties

##   zookeeper
Port 2181
```bash

$ ./zookeeper-server-start ../etc/kafka/zookeeper.properties   pour démarrer zookeeper 
$ systemctl start confluent-zookeeper   pour démarrer zookeeper en mode service
$ ./zookeeper-server-stop ../etc/kafka/zookeeper.properties  pour arrêter zookeeper
$  systemctl stop confluent-zookeeper (pour arrêter zookeeper en mode service)
$  systemctl status confluent-zookeeper  ( pour vérifier  le status en mode service)

```


##  Kafka
Port 9092

```bash
$ ./kafka-server-stop ../etc/kafka/server.properties   pour démarrer kafka 
$  systemctl start confluent-server   pour démarrer kafka en mode service
$ ./kafka-server-stop ../etc/kafka/server.properties  pour arrêter kafka
$  systemctl stop confluent-zookeeper 
$  systemctl status confluent-zookeeper 
```


## Topic

Quelques paramètres par défaut d'un topic à savoir:
* Retention ( durée de vie d'un message): 7 jours 
* Strategie ( compact ou delete) : delete
* Nombre de partition par défaut : 3 
C'est suffisant pour ce TP, mais  Il y en existe  d'autres  
* Norme de nommage : Un topic doit être versionné, donc sa version doit figurer dans son nom: exemple receipt-v1
## Utilisation de script kafka-topics 
Dans ce qui suit, les commandes à partir d'un  service  c'est kafka-topics sinon  c'est kafka-topics.sh 
```bash
  Lister les topic
     $ kafka-topics --zookeeper localhost:2181   --list  topics
  Créer un topic avec les parametres par défaut
     $ kafka-topics --create --topic  stock-init-v1 --zookeeper localhost:2181  --replication-factor 1
  Creation topic avec retention ( delete ) de 5 minutes. données stockées pendant 5 minutes 
     $ kafka-topics --create --topic  stock-init-v1 --zookeeper 10.127.0.1:2181 --config cleanup.policy=delete  --config  delete.retention.ms=300000   --config  retention.ms=300000  --partitions 5  --replication-factor 1
  Creation topic avec retention ( compact ) de 5 minutes. suppression de doublons
     $ kafka-topics --create --topic  stock-init-v1 --zookeeper 10.127.0.1:2181 --config cleanup.policy=compact  --partitions 5  --replication-factor 1
  Inspecter( analyser)  un topic 
     $ kafka-topics  --zookeeper localhost:2181 --describe --topic test
  Mise à jour de topic avec retention.ms=300000 ( utiliser la commande --alter --add-config ) 
     $ kafka-configs --zookeeper localhost:2181  --entity-type topics --entity-name  rdo-demat-ticket-v1   --alter --add-config  retention.ms=300000
  Suppression de topic 
     - Dans la vraie la pratique,  il faut désactiver la création automatique de topic  ( /etc/kafka/server.properties) 
     - Dans certains cas, désactiver la suppression des topics   ( /etc/kafka/server.properties) 
     $ bin/kafka-topics.sh --zookeeper 127.0.0.1:2181 --delete --topic someTopic

```

## Producer 
Utilisation du poducer par defaut pour alimenter un topic
./kafka-console-producer.sh --broker-list localhost:9092 --topic topicName


## Consumer 
```bash
Utilisation du consumer par defaut de kafka
$ ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic stock-init-v1  --from-beginning
Création d'un groupe de consumers et ajout d'un consumer à un groupe
$ kafka-acls --authorizer-properties zookeeper.connect={{zookeeper_node_cmd}}:2181  --add --allow-principal  --consumer --topic stock-init-v1  --topic stock-couchbase-v1  --topic stock-aggregate-v1  --topic stock-output-v1 --topic stock-error-v1 --topic stock-pubsub-v1   --group stream-aggregate  
```
```