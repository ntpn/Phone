package connection;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javabean.PhoneInfo;
import javabean.SetOfPhones;

public class SolrConn {
	static String urlString = "http://localhost:8983/solr/phone";
	static HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();

	public SetOfPhones getNewfeed(int pages) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.setStart(pages*10);
		//query.setSort("time_post", SolrQuery.ORDER.desc);
		query.setRows(10);
		QueryResponse response = solr.query(query);
		SolrDocumentList results = response.getResults();
		return new SetOfPhones(results.getNumFound(), setToPhone(results));
	}
			
	public SetOfPhones searchNews(String input, int pages) throws SolrServerException, IOException {
		if (input != "") {
			String queryLine = "";
			
			String[] words = input.split(" ");
			
			for (int i = 0; i < words.length - 1; i++) {
				queryLine = queryLine + "\""+ words[i] + "\" AND ";
			}
			queryLine = queryLine + "\""+ words[words.length-1] + "\"";
			
			//queryLine = "body:\""+ input + "\"";;
			SolrQuery query = new SolrQuery();
			query.setQuery(queryLine);
			//query.setSort("time_post", SolrQuery.ORDER.desc);
			query.setStart(pages*10);
			query.setRows(10);
			query.set("df","name");
			QueryResponse response = solr.query(query);			
			SolrDocumentList results = response.getResults();
			return new SetOfPhones(results.getNumFound(), setToPhone(results));
		} else {
			return getNewfeed(pages);
		}
	}
	/*
	public SetOfPhones searchByCategory(String input, int pages) throws SolrServerException, IOException {
			String queryLine = input; //"category:\""+ input + "\"";
			SolrQuery query = new SolrQuery();
			query.setQuery(queryLine);
			//query.setSort("time_post", SolrQuery.ORDER.desc);
			query.setStart(pages*10);
			query.setRows(10);
			query.set("df","category");
			QueryResponse response = solr.query(query);			
			SolrDocumentList results = response.getResults();
			return new SetOfPhones(results.getNumFound(), setToPhone(results));
	}
	*/
	public PhoneInfo getNewByID(String id) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		SolrDocument result = solr.getById(id);
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		PhoneInfo phone = mapper.readValue(result.jsonStr(), PhoneInfo.class);
		return phone;
	}

	public ArrayList<PhoneInfo> setToPhone(SolrDocumentList results)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<PhoneInfo> list = new ArrayList<PhoneInfo>();
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		for (int i = 0; i < results.size(); ++i) {
			PhoneInfo phone = mapper.readValue(results.get(i).jsonStr(), PhoneInfo.class);
			list.add(phone);
		}
		return list;
	}
	public static void main(String[] args ) throws JsonParseException, JsonMappingException, IOException, SolrServerException {
		SolrQuery query = new SolrQuery();
		query.setQuery("name:\""+ "samsung" + "\"");
		//query.setSort("time_post", SolrQuery.ORDER.desc);
		query.setStart(0);
		query.setRows(10);
		query.set("df","name");
		QueryResponse response = solr.query(query);
		SolrDocumentList results = response.getResults();
		ArrayList<PhoneInfo> list = new ArrayList<PhoneInfo>();
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		for (int i = 0; i < results.size(); ++i) {
			PhoneInfo phone = mapper.readValue(results.get(i).jsonStr(), PhoneInfo.class);
			list.add(phone);
		}
		System.out.println(list.get(1).getPrice_hoangha());
	
	}
}
