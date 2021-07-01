FROM lakoo/node-gcloud-docker


RUN apk add unzip curl

RUN curl https://releases.hashicorp.com/terraform/1.0.1/terraform_1.0.1_linux_amd64.zip -o terraform.zip
RUN unzip terraform.zip
RUN mv terraform /usr/local/bin/


RUN curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
RUN install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

RUN terraform -help
RUN kubectl --help