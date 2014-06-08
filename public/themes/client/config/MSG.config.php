<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
//http://g.phongmay.zing.vn/promotion_staging/web/msg.29.8a6e1115c9ab5930cf5f9e0f0c422a88.view.html 
$promotion_id = 29;
$client_config[$promotion_id]['server_ip']=120;
$client_config[$promotion_id]['title']='Nhận code 3Q';
$client_config[$promotion_id]['playingtime']=0;
$client_config[$promotion_id]['level']=3;
$client_config[$promotion_id]['from_date']='2013/03/25 10:00:00.000';
$client_config[$promotion_id]['to_date']='2014/04/10 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60*60*24*15; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'leminhnguyen07'=>1,'tieuminh1907'=>1,'tranngoclinh2812'=>1,'linhxedap'=>1,'sinhnd03'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=3; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Lịch sử nhận code','link'=>'msg.29.8a6e1115c9ab5930cf5f9e0f0c422a88.history.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code 3Q','link'=>'msg.29.8a6e1115c9ab5930cf5f9e0f0c422a88.view.html'); 
$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Đăng ký','link'=>'msg.29.8a6e1115c9ab5930cf5f9e0f0c422a88.reg.html'); 

$promotion_id = 31;
$client_config[$promotion_id]['server_ip']=131;
$client_config[$promotion_id]['title']='Nhận code 3Q';
$client_config[$promotion_id]['playingtime']=30;
$client_config[$promotion_id]['level']=3;
$client_config[$promotion_id]['from_date']='2014/03/14 17:00:00.000';
$client_config[$promotion_id]['to_date']='2014/03/24 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60*60*24*15; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'leminhnguyen07'=>1,'tieuminh1907'=>1,'tranngoclinh2812'=>1,'linhxedap'=>1,'sinhnd03'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=2; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Lịch sử nhận code','link'=>'msg.31.1f6b4e12479dfdd2839261beb949f6a9.history.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code 3Q','link'=>'msg.31.1f6b4e12479dfdd2839261beb949f6a9.view.html'); 
//$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Đăng ký','link'=>'msg.31.1f6b4e12479dfdd2839261beb949f6a9.reg.html'); 

?>