1.Cài solr (solr 8.0.0)
2.Chạy solr: Tại thư mục solr-8.0.0:
- Chạy: bin/solr start
3.Tạo core (standalon) mới (core Phone):
  bin/solr create -c Phone
4.Thêm file json vào core (thêm file match.json trong thư mục Phone vào core Phone):
bin/post -c Phone Phone/match.json
