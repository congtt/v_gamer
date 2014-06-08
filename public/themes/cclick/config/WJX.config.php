<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
//http://g.phongmay.zing.vn/cclick/WJX/28/   
//http://g.phongmay.zing.vn/promotion_staging/ccp/ccp.28.1ce2d6ec5b7a7571c215caa2eec5b085.view.html 
/***********1**********************/
$promotion_id = 28;
$ccp_config[$promotion_id]['server_ip']=131;
$ccp_config[$promotion_id]['title']='Nhận code Kiếm thế';
$ccp_config[$promotion_id]['playingtime']=0;
$ccp_config[$promotion_id]['from_date']='2014/03/05 10:00:00';
$ccp_config[$promotion_id]['to_date']='2014/03/31 23:59:59';
$ccp_config[$promotion_id]['type_id']=4;//1: playingtime daily, 2 playingtime program , 3: Level , 4:ZingId
$ccp_config[$promotion_id]['programId']=0;
$ccp_config[$promotion_id]['daily']=1;
$ccp_config[$promotion_id]['link']=2; //1: Đăng ký ,2 : Nhận Code ;
$ccp_config[$promotion_id]['cache_time']=60*60*24*15; //s --60*60*24*15
//$ccp_config[$promotion_id]['debug']=array('tranngoclinh2812'=>1); 

//$ccp_config[$promotion_id]['debug']=array('cat_vang613'=>1); 
//$ccp_config[3]['leftMenu'][1]=array('name'=>'Mode 1','link'=>''); 
//$ccp_config[3]['leftMenu'][2]=array('name'=>'Mode 2','link'=>''); 
//$ccp_config[3]['leftMenu'][3]=array('name'=>'Mode 2','link'=>'HTTP://WWW.YAHOO.COM'); 
/**********************************/
?>
