docker run -e ARANGO_NO_AUTH=1 -d --name arangodb-instance -p 8529:8529 -d arangodb/arangodb
docker run -d --name couchbase-instance -p 8091-8094:8091-8094 -p 11210:11210 couchbase
docker run --name elasticsearch-instance -p 9300:9300 -p 9200:9200 -d elasticsearch
docker run -d --name orientdb -p 2424:2424 -p 2480:2480 -e ORIENTDB_ROOT_PASSWORD=rootpwd orientdb
docker run --name redis-instance -p 6379:6379 -d redis
docker run --name riak-instance -d -p 8087:8087 -p 8098:8098 basho/riak-ts
