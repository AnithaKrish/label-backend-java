# label-backend-java

APIs:

1. GET ALL LABELS:
     METHOD: GET
     curl --location 'http://localhost:8080/label/all'
   
2. CREATE LABEL:
    METHOD: POST
    curl --location 'http://localhost:8080/label' \
    --header 'Content-Type: application/json' \
    --data '{
        "name":"Interview",
        "parentId":""
    }
