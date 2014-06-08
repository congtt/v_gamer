<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
//http://g.phongmay.zing.vn/promotion_staging/web/zg.35.e1cca2fe883171e3676fd8209e460baa.view.html  
$promotion_id = 35;
$client_config[$promotion_id]['server_ip']=131;
$client_config[$promotion_id]['title']='Nhận code Gunny';
$client_config[$promotion_id]['playingtime']=0;
$client_config[$promotion_id]['level']=3;
$client_config[$promotion_id]['from_date']='2014/03/18 14:00:00.000';
$client_config[$promotion_id]['to_date']='2014/03/31 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60*60*24*15; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'leminhnguyen07'=>1,'tranngoclinh2812'=>1,'skyonlyone89'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=3; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Lịch sử nhận code','link'=>'zg.35.e1cca2fe883171e3676fd8209e460baa.history.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code loại 3','link'=>'zg.35.e1cca2fe883171e3676fd8209e460baa.view.2.html'); 
$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Nhận code loại 2','link'=>'zg.35.e1cca2fe883171e3676fd8209e460baa.view.1.html'); 
$client_config[$promotion_id]['leftMenu'][4]=array('name'=>'Đăng ký','link'=>'zg.35.e1cca2fe883171e3676fd8209e460baa.reg.html'); 

?>