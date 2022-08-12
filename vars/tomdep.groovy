def call(ip,user,credId){
  sshagent([credId]) {
    sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat9/bin/tomcat-juli.jar"
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
                }   
}
