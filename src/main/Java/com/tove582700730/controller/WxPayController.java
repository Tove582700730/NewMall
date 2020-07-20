package com.tove582700730.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class WxPayController {
    public void generateCode(Integer oid, HttpServletResponse response){
        //1. 加载自己配置的MyWXConfig类(里面有对应商家的应用id 商家id 密钥)
        MyWXConfig myWXConfig = new MyWXConfig();
        try {
            WXPay wxpay = new WXPay(myWXConfig);
            Map<String, String> data = new HashMap<String, String>();
            data.put("body", "千锋-山科大");//商品描述
            data.put("out_trade_no", System.currentTimeMillis()+"");//商户订单号  唯一
            data.put("device_info", "");
            data.put("fee_type", "CNY");//人民币
            data.put("total_fee", "1");//1分钱  单位是分
            data.put("spbill_create_ip", "123.12.12.123");
            //这里使用的是内网穿透的ip，来调用下面的通知的接口
            data.put("notify_url", "http://vfbf68.natappfree.cc/pay/notifyUrl");//异步接收微信支付结果通知的回调地址
            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
            data.put("product_id", "12");
            //2. 调用统一下单接口
            //返回的resp中包含生成二维码的支付短链接
            Map<String, String> resp = wxpay.unifiedOrder(data);
            //3. 使用zxing将链接生成二维码
            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//编码格式
            hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);//容错率
            //边距
            hints.put(EncodeHintType.MARGIN,2);
            //生成二维码图片
            BitMatrix bitMatrix = new MultiFormatWriter().encode(resp.get("code_url"), BarcodeFormat.QR_CODE, 200, 200, hints);
            //把生成的图片使用输出流反馈给前端
            MatrixToImageWriter.writeToStream(bitMatrix,"png",response.getOutputStream());
            System.out.println("二维码创建完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
