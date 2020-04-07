package kr.or.connect.project3.dao;

public class MainpageDaoSqls {
	public static final String IMAGE_SELECT = "SELECT id,product_id FROM product_image WHERE type = :type";
	public static final String PROMOTION_COUNT = "SELECT count(*) FROM promotion ";
	public static final String PROMOTION_SELECT = "SELECT* FROM promotion";
	public static final String SELECT_DISPLAY_INFO = "SELECT place FROM display_info";
	public static final String PRODUCT_ALL = "SELECT* FROM product order by id";
	public static final String PRODUCT_SELECT = "SELECT* FROM product WHERE category_id = :categoryId";
	public static final String DISPLAY_INFO_ALL = "SELECT*  FROM display_info order by id";
	
	public static final String DISPLAYINFO_SELECT = "SELECT*  FROM display_info WHERE product_id = :productId ";
	public static final String IMAGE_SELECTBYPID = "SELECT id,product_id FROM product_image WHERE product_id = :productId,type = :type";
	
}
