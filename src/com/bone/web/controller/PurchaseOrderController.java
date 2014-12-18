package com.bone.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bone.assemble.order.CollectionMoneyRecordAssemble;
import com.bone.assemble.order.PurchaseOrderAssemble;
import com.bone.assemble.order.PurchaseOrderDispalyInfoAssemble;
import com.bone.assemble.order.PurchaseOrderSimpleDisplayInfoAssemble;
import com.bone.assemble.order.SendGoodsRecordAssemble;
import com.bone.domain.order.CollectionMoneyRecord;
import com.bone.domain.order.PurchaseOrder;
import com.bone.domain.order.SendGoodsRecord;
import com.bone.service.order.ICollectionMoneyRecordService;
import com.bone.service.order.IPurchaseOrderService;
import com.bone.service.order.ISendGoodsRecordService;
import com.bone.tools.DateHelper;

@Controller
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrderService purchaseOrderService;
	@Autowired
	private ICollectionMoneyRecordService collectionMoneyRecordService;
	@Autowired
	private ISendGoodsRecordService sendGoodsRecordService;
	
	@RequestMapping("/add.json")
	public @ResponseBody JsonResultInfo login(PurchaseOrderCommitInfo purchaseOrderCommitInfo) throws Exception {
	 	System.out.print(purchaseOrderCommitInfo);
	 	PurchaseOrder purchaseOrder = PurchaseOrderAssemble.create(purchaseOrderCommitInfo);
		purchaseOrderService.persist(purchaseOrder);
		return new JsonResultInfo(0,"");
	}
	
	@RequestMapping("/list.json")
	public @ResponseBody Map list() throws Exception {
		List<PurchaseOrderSimpleDisplayInfo> list = new ArrayList<PurchaseOrderSimpleDisplayInfo>();
		Map<String,Object> map = new HashMap<String,Object>();
		List<PurchaseOrder> purchaseOrders= purchaseOrderService.find();
		map.put("rows", PurchaseOrderSimpleDisplayInfoAssemble.create(purchaseOrders));
		map.put("total", "15");
		return map;
	}
	
	@RequestMapping("/sendGoods.json")
	public @ResponseBody JsonResultInfo sendGoods(SendGoodsCommitInfo sendGoodsCommitInfo) throws Exception {
	 	System.out.print(sendGoodsCommitInfo);
	 	PurchaseOrder purchaseOrder= purchaseOrderService.find(sendGoodsCommitInfo.getPurchaseOrderId());
	 	
	 	SendGoodsRecord sendGoodsRecord = SendGoodsRecordAssemble.create(sendGoodsCommitInfo,purchaseOrder);
		purchaseOrderService.persist(sendGoodsRecord);
		return new JsonResultInfo(0,"");
	}
	
	@RequestMapping("/collectionMoney.json")
	public @ResponseBody JsonResultInfo sendGoods(CollectionMoneyCommitInfo collectionMoneyCommitInfo) throws Exception {
	 	System.out.print(collectionMoneyCommitInfo);
	 	PurchaseOrder purchaseOrder= purchaseOrderService.find(collectionMoneyCommitInfo.getPurchaseOrderId());
	 	
	 	CollectionMoneyRecord collectionMoneyRecord = CollectionMoneyRecordAssemble.create(collectionMoneyCommitInfo,purchaseOrder);
		purchaseOrderService.persist(collectionMoneyRecord);
		return new JsonResultInfo(0,"");
	}
	
	@RequestMapping("/getCollectionMoneyInfo.json")
	public @ResponseBody Map<String,Object> getCollectionMoneyInfo(String purchaseOrderCode) throws Exception {
		List<CollectionMoneyRecord> collectionMoneyRecords= collectionMoneyRecordService.findByPurchaseOrderCode(purchaseOrderCode);
	 	List<CollectionMoneyDispalyInfo> collectionMoneyDispalyInfos = new ArrayList<CollectionMoneyDispalyInfo>();
	 	for(CollectionMoneyRecord collectionMoneyRecord:collectionMoneyRecords){
	 		collectionMoneyDispalyInfos.add(
	 				new CollectionMoneyDispalyInfo(collectionMoneyRecord.getPurchaseOrder().getCode(), 
	 						DateHelper.toDateString(collectionMoneyRecord.getCollectionTime()), 
	 						collectionMoneyRecord.getMoney().toString(), collectionMoneyRecord.getRemark()));
	 	}
	 	Map<String,Object> map = new HashMap<String,Object>();
	 	map.put("rows", collectionMoneyDispalyInfos);
		map.put("total", collectionMoneyDispalyInfos.size()+"");
		return map;
	}
	
	@RequestMapping("/getSendGoodsInfo.json")
	public @ResponseBody Map<String,Object> getSendGoodsInfo(String purchaseOrderCode) throws Exception {
		List<SendGoodsRecord> sendGoodsRecords= sendGoodsRecordService.findByPurchaseOrderCode(purchaseOrderCode);
	 	List<SendGoodsDispalyInfo> sendGoodsDispalyInfos = new ArrayList<SendGoodsDispalyInfo>();
	 	for(SendGoodsRecord sendGoodsRecord:sendGoodsRecords){
	 		sendGoodsDispalyInfos.add(
	 				new SendGoodsDispalyInfo(sendGoodsRecord.getPurchaseOrder().getCode(), 
	 						DateHelper.toDateString(sendGoodsRecord.getSendTime()), 
	 						sendGoodsRecord.getSendCode(), sendGoodsRecord.getRemark()));
	 	}
	 	Map<String,Object> map = new HashMap<String,Object>();
	 	map.put("rows", sendGoodsDispalyInfos);
		map.put("total", sendGoodsDispalyInfos.size()+"");
		return map;
	}
	
	@RequestMapping("/getPurchaseOrder.json")
	public @ResponseBody JsonResultInfo getPurchaseOrder(String purchaseOrderCode) throws Exception {
		PurchaseOrder purchaseOrder= purchaseOrderService.find(purchaseOrderCode);
		PurchaseOrderDispalyInfo purchaseOrderDispalyInfo = PurchaseOrderDispalyInfoAssemble.create(purchaseOrder);
		return new JsonResultInfo(purchaseOrderDispalyInfo);
	}
}
