<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
//http://g.phongmay.zing.vn/cclick/ZS/26/ 
//http://g.phongmay.zing.vn/promotion_staging/web/zs.38.20ce5e3f040151973db5dc13d9570b4a.view.html
$promotion_id = 38;
//$client_config[$promotion_id]['debug']=array('vdvdvd44'=>1); 
$client_config[$promotion_id]['server_ip']=131;
$client_config[$promotion_id]['title']='Nhận code 2S';
$client_config[$promotion_id]['playingtime']=0;
$client_config[$promotion_id]['level']=20;
$client_config[$promotion_id]['from_date']='2014/03/28 10:00:00.000';
$client_config[$promotion_id]['to_date']='2014/04/27 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60;//*60*24*60; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'bomprom20141'=>1,'bomprom20144'=>1,'bomprom20145'=>1,'linhxedap'=>1,'sinhnd03'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=3; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Lịch sử nhận code','link'=>'zs.38.20ce5e3f040151973db5dc13d9570b4a.history.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code 2S','link'=>'zs.38.20ce5e3f040151973db5dc13d9570b4a.view.html'); 
$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Đăng ký','link'=>'zs.38.20ce5e3f040151973db5dc13d9570b4a.reg.html'); 

?>