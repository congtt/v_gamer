<?php 
if(!defined('TSEntry') || !TSEntry) die('Not A Valid Entry Point');
//http://g.phongmay.zing.vn/promotion_staging/web/boom.36.de44d4ebf4312280987232f8aecddfa1.view.html 
$promotion_id = 37;
$client_config[$promotion_id]['server_ip']=120;
$client_config[$promotion_id]['title']='Nhận thưởng Ngọa Long';
$client_config[$promotion_id]['playingtime']=0;
$client_config[$promotion_id]['level']=0; 
$client_config[$promotion_id]['from_date']='2014/03/27 16:00:00.000';
$client_config[$promotion_id]['to_date']='2014/04/07 23:59:00.000';
$client_config[$promotion_id]['cache_time']=60*60*24*15; //s
//$client_config[$promotion_id]['debug']=array('minhngo324'=>1,'bomprom20141'=>1,'bomprom20144'=>1,'bomprom20145'=>1,'linhxedap'=>1,'sinhnd03'=>1); 
$client_config[$promotion_id]['type']='web';
$client_config[$promotion_id]['programId']='';
$client_config[$promotion_id]['link']=0; //1: Đăng ký ,2 : Nhận Code ;
$client_config[$promotion_id]['leftMenu'][1]=array('name'=>'Nhận code thưởng từ đua top server Hỏa Hổ','link'=>'nlvn.37.c17039ddfaf3164ccd01414681585075.view.3.html'); 
$client_config[$promotion_id]['leftMenu'][2]=array('name'=>'Nhận code thưởng từ đua top online','link'=>'nlvn.37.c17039ddfaf3164ccd01414681585075.view.2.html'); 
$client_config[$promotion_id]['leftMenu'][3]=array('name'=>'Nhận code thưởng từ đua top nạp tiền','link'=>'nlvn.37.c17039ddfaf3164ccd01414681585075.view.1.html'); 
