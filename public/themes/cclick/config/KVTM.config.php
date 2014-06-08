<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
/***********1**********************/
$promotion_id = 18;
$ccp_config[$promotion_id]['server_ip']=131;
$ccp_config[$promotion_id]['title']='Nhận code Khu vườn trên mây';
$ccp_config[$promotion_id]['playingtime']=0;
$ccp_config[$promotion_id]['from_date']='2014/01/22 14:00:00';
$ccp_config[$promotion_id]['to_date']='2014/02/16 23:59:59';
$ccp_config[$promotion_id]['type_id']=4;//1: playingtime daily, 2 playingtime program , 3: Level , 4:ZingId
$ccp_config[$promotion_id]['programId']=0;
$ccp_config[$promotion_id]['daily']=1;
$ccp_config[$promotion_id]['link']=2; //1: Đăng ký ,2 : Nhận Code ;
$ccp_config[$promotion_id]['cache_time']=60*60*24*15; //s --60*60*24*15
//$ccp_config[$promotion_id]['debug']=array('cat_vang613'=>1); 
//$ccp_config[3]['leftMenu'][1]=array('name'=>'Mode 1','link'=>''); 
//$ccp_config[3]['leftMenu'][2]=array('name'=>'Mode 2','link'=>''); 
//$ccp_config[3]['leftMenu'][3]=array('name'=>'Mode 2','link'=>'HTTP://WWW.YAHOO.COM'); 
/**********************************/
?>
