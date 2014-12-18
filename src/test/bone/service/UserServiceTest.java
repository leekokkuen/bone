package test.bone.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bone.domain.order.CollectionMoneyRecord;
import com.bone.domain.order.PurchaseOrder;
import com.bone.domain.order.SendGoodsRecord;
import com.bone.domain.user.User;
import com.bone.service.order.ICollectionMoneyRecordService;
import com.bone.service.order.IPurchaseOrderService;
import com.bone.service.order.ISendGoodsRecordService;
import com.bone.service.user.IUserService;
import com.bone.tools.DateHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"../../../applicationContext.xml"})

public class UserServiceTest {
	
	@Resource
    private IUserService userService;
	@Resource 
	private IPurchaseOrderService purchaseOrderService;
	@Resource
	private ICollectionMoneyRecordService collectionMoneyRecordService;
	
	@Resource
	private ISendGoodsRecordService sendGoodsRecordService;
    @Test
    public void testAddOpinion1() {
    	try {
    		userService.persist(new User("test111","test1123"));
 		}catch (Exception e) {
 			e.printStackTrace();
 		}
    }
    
    @Test
    public void testPurchaseOrderService() {
    	try {
    		List<PurchaseOrder> list =  purchaseOrderService.find();
    		SendGoodsRecord sendGoodsRecord = 
    				new SendGoodsRecord(list.get(0), DateHelper.getCurrentDateTime(), "0001", "备注");
    		purchaseOrderService.persist(sendGoodsRecord);
 		}catch (Exception e) {
 			e.printStackTrace();
 		}
    }
    
    @Test
    public void testCollectionMoneyRecord() {
    	try {
    		List<CollectionMoneyRecord> collectionMoneyRecord =  collectionMoneyRecordService.findByPurchaseOrderCode("10000000000000001");
    		System.out.print(collectionMoneyRecord);
 		}catch (Exception e) {
 			e.printStackTrace();
 		}
    }
}
