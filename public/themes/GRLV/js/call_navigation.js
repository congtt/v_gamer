$(document).ready(function(){if(jQuery("#mainNav").length>0){$("#mainNav").addNavigation({event:"mouseover",effect:false,activeSection:activemenu_nav})}if(jQuery("#sidenav").length>0){$("#sidenav").addNavigationLeft({event:"click",effect:true,activeSection:activesidenav,callback:function(){showActive()}})}});function showActive(){$("#sidenav").find(".Hilite").addClass("Active");$("#sidenav").find(".Hilite").each(function(){var a=$(this);a.find("ul:first").show()})}; 