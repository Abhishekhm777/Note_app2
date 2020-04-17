package com.souvik.noteapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class ProductModel {

    @Expose
    @SerializedName("filters")
    private List<String> filters;
    @Expose
    @SerializedName("products")
    private Products products;

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public static class Products {
        @Expose
        @SerializedName("page")
        private Page page;
        @Expose
        @SerializedName("content")
        private List<Content> content;
        @Expose
        @SerializedName("links")
        private List<Links> links;

        public Page getPage() {
            return page;
        }

        public void setPage(Page page) {
            this.page = page;
        }

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        public List<Links> getLinks() {
            return links;
        }

        public void setLinks(List<Links> links) {
            this.links = links;
        }
    }

    public static class Page {
        @Expose
        @SerializedName("number")
        private int number;
        @Expose
        @SerializedName("totalPages")
        private int totalPages;
        @Expose
        @SerializedName("totalElements")
        private int totalElements;
        @Expose
        @SerializedName("size")
        private int size;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

   public static class Content {
        @Expose
        @SerializedName("links")
        private List<Links> links;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("lastModified")
        private String lastModified;
        @Expose
        @SerializedName("createdOn")
        private String createdOn;
        @Expose
        @SerializedName("features")
        private List<String> features;
        @Expose
        @SerializedName("specification")
        private List<Specification> specification;
        @Expose
        @SerializedName("videosGridFsID")
        private List<String> videosGridFsID;
        @Expose
        @SerializedName("images")
        private List<String> images;
        @Expose
        @SerializedName("cloudinaryImagePublicIds")
        private List<String> cloudinaryImagePublicIds;
        @Expose
        @SerializedName("imageGridFsID")
        private List<String> imageGridFsID;
        @Expose
        @SerializedName("qrCode")
        private String qrCode;
        @Expose
        @SerializedName("version")
        private int version;
        @Expose
        @SerializedName("brand")
        private String brand;

        private List<Object> imageDetails;
        @Expose
        @SerializedName("categoriesPath")
        private List<String> categoriesPath;
        @Expose
        @SerializedName("priority")
        private int priority;
        @Expose
        @SerializedName("wholesaler")
        private int wholesaler;
        @Expose
        @SerializedName("customOf")
        private String customOf;
        @Expose
        @SerializedName("returnable")
        private boolean returnable;
        @Expose
        @SerializedName("dynamicPriceEnabled")
        private boolean dynamicPriceEnabled;
        @Expose
        @SerializedName("requiredDayesToDeliver")
        private int requiredDayesToDeliver;
        @Expose
        @SerializedName("manufactureCompany")
        private String manufactureCompany;
        @Expose
        @SerializedName("manufactureMobile")
        private String manufactureMobile;
        @Expose
        @SerializedName("manufactureName")
        private String manufactureName;
        @Expose
        @SerializedName("newLaunch")
        private boolean newLaunch;
        @Expose
        @SerializedName("showable")
        private boolean showable;
        @Expose
        @SerializedName("accessclassPriority")
        private int accessclassPriority;
        @Expose
        @SerializedName("availableCount")
        private int availableCount;
        @Expose
        @SerializedName("inventoryType")
        private String inventoryType;
        @Expose
        @SerializedName("productStatus")
        private String productStatus;
        @Expose
        @SerializedName("productType")
        private String productType;
        @Expose
        @SerializedName("sku")
        private String sku;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private String id;

        public List<Links> getLinks() {
            return links;
        }

        public void setLinks(List<Links> links) {
            this.links = links;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLastModified() {
            return lastModified;
        }

        public void setLastModified(String lastModified) {
            this.lastModified = lastModified;
        }

        public String getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(String createdOn) {
            this.createdOn = createdOn;
        }

        public List<String> getFeatures() {
            return features;
        }

        public void setFeatures(List<String> features) {
            this.features = features;
        }

        public List<Specification> getSpecification() {
            return specification;
        }

        public void setSpecification(List<Specification> specification) {
            this.specification = specification;
        }

        public List<String> getVideosGridFsID() {
            return videosGridFsID;
        }

        public void setVideosGridFsID(List<String> videosGridFsID) {
            this.videosGridFsID = videosGridFsID;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getCloudinaryImagePublicIds() {
            return cloudinaryImagePublicIds;
        }

        public void setCloudinaryImagePublicIds(List<String> cloudinaryImagePublicIds) {
            this.cloudinaryImagePublicIds = cloudinaryImagePublicIds;
        }

        public List<String> getImageGridFsID() {
            return imageGridFsID;
        }

        public void setImageGridFsID(List<String> imageGridFsID) {
            this.imageGridFsID = imageGridFsID;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public List<Object> getImageDetails() {
            return imageDetails;
        }

        public void setImageDetails(List<Object> imageDetails) {
            this.imageDetails = imageDetails;
        }

        public List<String> getCategoriesPath() {
            return categoriesPath;
        }

        public void setCategoriesPath(List<String> categoriesPath) {
            this.categoriesPath = categoriesPath;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getWholesaler() {
            return wholesaler;
        }

        public void setWholesaler(int wholesaler) {
            this.wholesaler = wholesaler;
        }

        public String getCustomOf() {
            return customOf;
        }

        public void setCustomOf(String customOf) {
            this.customOf = customOf;
        }

        public boolean getReturnable() {
            return returnable;
        }

        public void setReturnable(boolean returnable) {
            this.returnable = returnable;
        }

        public boolean getDynamicPriceEnabled() {
            return dynamicPriceEnabled;
        }

        public void setDynamicPriceEnabled(boolean dynamicPriceEnabled) {
            this.dynamicPriceEnabled = dynamicPriceEnabled;
        }

        public int getRequiredDayesToDeliver() {
            return requiredDayesToDeliver;
        }

        public void setRequiredDayesToDeliver(int requiredDayesToDeliver) {
            this.requiredDayesToDeliver = requiredDayesToDeliver;
        }

        public String getManufactureCompany() {
            return manufactureCompany;
        }

        public void setManufactureCompany(String manufactureCompany) {
            this.manufactureCompany = manufactureCompany;
        }

        public String getManufactureMobile() {
            return manufactureMobile;
        }

        public void setManufactureMobile(String manufactureMobile) {
            this.manufactureMobile = manufactureMobile;
        }

        public String getManufactureName() {
            return manufactureName;
        }

        public void setManufactureName(String manufactureName) {
            this.manufactureName = manufactureName;
        }

        public boolean getNewLaunch() {
            return newLaunch;
        }

        public void setNewLaunch(boolean newLaunch) {
            this.newLaunch = newLaunch;
        }

        public boolean getShowable() {
            return showable;
        }

        public void setShowable(boolean showable) {
            this.showable = showable;
        }

        public int getAccessclassPriority() {
            return accessclassPriority;
        }

        public void setAccessclassPriority(int accessclassPriority) {
            this.accessclassPriority = accessclassPriority;
        }

        public int getAvailableCount() {
            return availableCount;
        }

        public void setAvailableCount(int availableCount) {
            this.availableCount = availableCount;
        }

        public String getInventoryType() {
            return inventoryType;
        }

        public void setInventoryType(String inventoryType) {
            this.inventoryType = inventoryType;
        }

        public String getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(String productStatus) {
            this.productStatus = productStatus;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Links {
        @Expose
        @SerializedName("href")
        private String href;
        @Expose
        @SerializedName("rel")
        private String rel;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }
    }

    public static class Specification {
        @Expose
        @SerializedName("attributes")
        private List<Attributes> attributes;
        @Expose
        @SerializedName("heading")
        private String heading;

        public List<Attributes> getAttributes() {
            return attributes;
        }

        public void setAttributes(List<Attributes> attributes) {
            this.attributes = attributes;
        }

        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }
    }

    public static class Attributes {
        @Expose
        @SerializedName("values")
        private List<String> values;
        @Expose
        @SerializedName("key")
        private String key;

        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values = values;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static class Link {
        @Expose
        @SerializedName("href")
        private String href;
        @Expose
        @SerializedName("rel")
        private String rel;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }
    }
}
