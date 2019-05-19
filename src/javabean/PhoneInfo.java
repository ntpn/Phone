package javabean;

import java.util.ArrayList;

import org.apache.solr.client.solrj.beans.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneInfo {

	@Field("id")
	private String id;
	
	@Field("_version_")
	private String _version_;
	
	@Field("camera")
	private String camera;
	
	@Field("cpu")
	private String cpu;
	
	@Field("display")
	private String display;
	
	@Field("name")
	private String name;
	
	@Field("os")
	private String os;
	
	@Field("pin")
	private String pin;
	
	@Field("ram")
	private String ram;
	
	@Field("rom")
	private String rom;
	
	@Field("sim")
	private String sim;
	
	@Field("url_image")
	private String url_image;
	/*
	@Field("price")
	@JsonProperty("price")
	private Price price;
	*/
	@Field("price.fpt")
	@JsonProperty("price.fpt")
	private ArrayList<String> price_fpt;
	
	@Field("price.hoangha")
	@JsonProperty("price.hoangha")
	private ArrayList<String> price_hoangha;
	
	@Field("price.thegioididong")
	@JsonProperty("price.thegioididong")
	private ArrayList<String> price_tgdd;
	
	@Field("url_link.fpt")
	@JsonProperty("url_link.fpt")
	private ArrayList<String> url_link_fpt;
	
	@Field("url_link.hoangha")
	@JsonProperty("url_link.hoangha")
	private ArrayList<String> url_link_hoangha;
	
	@Field("url_link.thegioididong")
	@JsonProperty("url_link.thegioididong")
	private ArrayList<String> url_link_tgdd;
	/*
	@Field("url_link")
	@JsonProperty("url_link")
	private Url_link link;
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get_version_() {
		return _version_;
	}
	public void set_version_(String _version_) {
		this._version_ = _version_;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getUrl_image() {
		return url_image;
	}
	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}
	public ArrayList<String> getPrice_fpt() {
		return price_fpt;
	}
	public void setPrice_fpt(ArrayList<String> price_fpt) {
		this.price_fpt = price_fpt;
	}
	public ArrayList<String> getPrice_hoangha() {
		return price_hoangha;
	}
	public void setPrice_hoangha(ArrayList<String> price_hoangha) {
		this.price_hoangha = price_hoangha;
	}
	public ArrayList<String> getPrice_tgdd() {
		return price_tgdd;
	}
	public void setPrice_tgdd(ArrayList<String> price_tgdd) {
		this.price_tgdd = price_tgdd;
	}
	public ArrayList<String> getUrl_link_fpt() {
		return url_link_fpt;
	}
	public void setUrl_link_fpt(ArrayList<String> url_link_fpt) {
		this.url_link_fpt = url_link_fpt;
	}
	public ArrayList<String> getUrl_link_hoangha() {
		return url_link_hoangha;
	}
	public void setUrl_link_hoangha(ArrayList<String> url_link_hoangha) {
		this.url_link_hoangha = url_link_hoangha;
	}
	public ArrayList<String> getUrl_link_tgdd() {
		return url_link_tgdd;
	}
	public void setUrl_link_tgdd(ArrayList<String> url_link_tgdd) {
		this.url_link_tgdd = url_link_tgdd;
	}
	
	
}
