# KURULUMLAR

## MongoDB İşlemler

    Not: MongoDB ile işlem yaparken admin kullanıcısı ve admin şifresi kullanılmamalıdır. Bu nedenle 
    oluşturulacak her DB için yeni kullanıcı ve şifre tanımlanır.
    1- Önecelikle DB yi tanımlayın
    2- üzerinde çalışma yapabilme için mongoDb Compass üzerinden MONGOSH ı açın (sol en altta)
    3- "use DB_Adı" şeklinde komut girilir.
    4- bu DB yi yönetecek olan bir kullanıcı tanımlıyorsunuz.
    db.createUser({
        user: "defaultUSer",
        pwd: "bilge!*123",
        roles: ["readWrite", "dbAdmin"]
    })

    -> db.createUser({user: "defaultUser",pwd: "bilge!*123",roles: ["readWrite", "dbAdmin"]})

### DOCKER ÜZERİNDE MONGODB KURULUMU

    docker run --name mongodb -e "MONGO_INITDB_ROOT_USERNAME=admin" -e "MONGO_INITDB_ROOT_PASSWORD=root" -p 27017:27017 mongo:7.0-rc-jammy


### DOCKER POSTGRESQL KURULUMU

     docker run --name postgresdb -e POSTGRES_PASSWORD=root -p 5433:5432 -d postgres

### DİKKAT Mac M1,M2,M3 işlemcilerde docker imaj oluştururken yapıalcak işlem

    --platform linux/amd64 komutu eklenmelidir.
    docker build -t javaboost2/java11boostauthmicroservice:v003 --platform linux/amd64 .
