<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
//http://g.phongmay.zing.vn/promotion_staging/web/drfb.30.a5cb8b9fb66e6ae3016a1b4e9091b5af.view.html 
$promotion_id = 30;
$client_config[$promotion_id]['server_ip']=120;
$client_config[$promotion_id]['title']='Nhận code Đảo Rồng';
$client_config[$promotion_id]['playingtime']=0;
$client_config[$promotion_id]['level']=3;
$client_config[$promotion_id]['from_date']='2013/03/25 10:00:00.000';
$client_config[$promotion_id]['to_date']='2014/04/10 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60*60*24*15; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'leminhnguyen07'=>1,'tranngoclinh2812'=>1,'sinhnd03'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=3; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Lịch sử nhận code','link'=>'drfb.30.a5cb8b9fb66e6ae3016a1b4e9091b5af.history.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code Đảo Rồng','link'=>'drfb.30.a5cb8b9fb66e6ae3016a1b4e9091b5af.view.html'); 
$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Đăng ký','link'=>'drfb.30.a5cb8b9fb66e6ae3016a1b4e9091b5af.reg.html'); 


// http://g.phongmay.zing.vn/promotion/web/drfb.33.6ec929298b246a57495588971e8b34f3.view.html 
$promotion_id = 33;
$client_config[$promotion_id]['server_ip']=131;
$client_config[$promotion_id]['title']='Nhận code Đảo Rồng';
$client_config[$promotion_id]['playingtime']=30;
$client_config[$promotion_id]['level']=3;
$client_config[$promotion_id]['from_date']='2014/03/14 17:00:00.000';
$client_config[$promotion_id]['to_date']='2014/03/24 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60*60*24*15; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'leminhnguyen07'=>1,'tranngoclinh2812'=>1,'sinhnd03'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=3; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Lịch sử nhận code','link'=>'drfb.33.6ec929298b246a57495588971e8b34f3.history.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code Đảo Rồng','link'=>'drfb.33.6ec929298b246a57495588971e8b34f3.view.html'); 
//$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Đăng ký','link'=>'drfb.33.6ec929298b246a57495588971e8b34f3.reg.html'); 


?>