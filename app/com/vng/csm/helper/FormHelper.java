package com.vng.csm.helper;

import java.util.HashMap;
import java.util.List;

import controllers.Application;
import controllers.Login;
import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;

public class FormHelper {

	// public static int type;

	// public static Html AddForm(String typeInput, String name, String value,
	// String title, String className, String style, List<HashMap<String,
	// String>> options) {
	//
	// Html content = views.html.forms.forms.render(type, typeInput, name,
	// value, title, className, style, options);
	// return content;
	// }
	//
	// public static Html addInput(String typeInput, String name, String value,
	// String title, String className, String style) {
	// type = 1;
	// return AddForm(typeInput, name, value, title, className, style, null);
	// }
	//
	// public static Html addSelectList(String name, String value, String title,
	// String className, String style, List<HashMap<String, String>> options) {
	// type = 2;
	// return AddForm("", name, value, title, className, style, options);
	// }
	//
	// public static Html addRadio(String name, String value, String title,
	// String className, String style, List<HashMap<String, String>> options) {
	// type = 3;
	// return AddForm("", name, value, title, className, style, options);
	// }

	/*
	 * function ($name, $rows = 4, $cols = 30, $value = '', $attr_ar = array() )
	 * { $str = "<textarea name=\"$name\" rows=\"$rows\" cols=\"$cols\""; if
	 * ($attr_ar) { $str .= addAttributes( $attr_ar ); } $str .=
	 * ">$value</textarea>"; return $str; }
	 */

	// function addSelectList2($name, $option_list, $header = NULL, $attr_ar =
	// array(),$OBJ,$slted = NULL) {
	// $str = "<select name=\"$name\" id=\"$name\" ";
	// if ($attr_ar) {
	// $str .= addAttributes( $attr_ar );
	// }
	// $str .= ">\n";
	// if ( isset($header) ) {
	// $str .= "  <option value=\"\">$header</option>\n";
	// }
	// foreach ( $option_list as $val => $text ) {
	// $str .= "<option value=\"$val\"  ";
	// if ( isset($_POST[$name]) && ( trim($_POST[$name]) === trim($val) ||
	// trim($_POST[$name]) === trim($text) ) || trim($slted) === trim($val) ) {
	// $str .= ' selected ';
	// }
	// $str .= ">$text</option>\n";
	// }
	// $str .= "</select>";
	// $OBJ->assign('_'.$name,$str);
	// return $str;
	// }
	//
	
	
	public static Html addSelectList2(String name, HashMap<String, String> options, String header, HashMap<String, String> attrList, String value) {

		String attr = addAttribute(attrList);
		String inp = "<select  name=\"" + name + "\" id=\"" + name + "\"" + attr + " />";
		if (header != null) {
			inp += "<option value=\"\" >" + header + "</option>";
		}
		if (options != null && !options.isEmpty()) {
			for (String key : options.keySet()) {

				if (value.equals(key)) {
					inp += "<option selected=\"selected\" value=\"" + key + "\" >" + options.get(key) + "</option>";
				} else {
					inp += "<option value=\"" + key + "\" >" + options.get(key) + "</option>";
				}
			}
		}

		return Html.apply(inp);
	}

	public static Html addSelectList2(String name, HashMap<String, String> options, String header, HashMap<String, String> attrList, HashMap<String, String> value, int size) {

		String attr = addAttribute(attrList);
		String inp = "<select multiple size=\"" + String.valueOf(size) + "\"  name=\"" + name + "\" id=\"" + name + "\"" + attr + " />";
		if (header != null) {
			inp += "<option value=\"\" >" + header + "</option>";
		}
		if (options != null && !options.isEmpty()) {
			for (String key : options.keySet()) {

				if (value.get(key) != null && value.get(key).equals(key)) {
					inp += "<option selected=\"selected\" value=\"" + key + "\" >" + options.get(key) + "</option>";
				} else {
					inp += "<option value=\"" + key + "\" >" + options.get(key) + "</option>";
				}
			}
		}
		return Html.apply(inp);
	}
	
	

	public static Html addSelectList(String name, List<HashMap<String, String>> options, String header, HashMap<String, String> attrList, HashMap<String, String> value, int size) {

		String attr = addAttribute(attrList);
		String inp = "<select  multiple  size=\"" + String.valueOf(size) + "\"  name=\"" + name + "\" id=\"" + name + "\"" + attr + " />";
		if (header != null) {
			inp += "<option value=\"\" >" + header + "</option>";
		}
		if (options != null && !options.isEmpty()) {
			HashMap<String, String> option = null;
			for (int i = 0; i < options.size(); i++) {
				option = options.get(i);
				String items = "";
				String optionName = "";
				optionName = option.get("name");
				option.remove("name");
				String itemValue = "";
				if (option != null && !option.isEmpty()) {
					itemValue = option.get("value");
					for (String key : option.keySet()) {
						items += key + " = \"" + option.get(key) + "\"";
					}
				}
				if (value.get(itemValue) != null && value.get(itemValue).equals(itemValue)) {
					inp += "<option " + items + " selected=\"selected\"  >" + optionName + "</option>";
				} else {
					inp += "<option " + items + " >" + optionName + "</option>";
				}
	
			}

		}
		return Html.apply(inp);
	}

	public static Html addSelectList(String name, List<HashMap<String, String>> options, String header, HashMap<String, String> attrList, String value) {
		
		String attr = addAttribute(attrList);
		String inp = "<select  name=\"" + name + "\" id=\"" + name + "\"" + attr + " />";
		if (header != null) {
			inp += "<option value=\"\" >" + header + "</option>";
		}
		if (options != null && !options.isEmpty()) {
			HashMap<String, String> option = null;
			for (int i = 0; i < options.size(); i++) {
				option = options.get(i);
				String items = "";
				String optionName = "";
				optionName = option.get("name");
				option.remove("name");
				String itemValue = "";
				if (option != null && !option.isEmpty()) {
					itemValue = option.get("value");
					for (String key : option.keySet()) {
						items += key + " = \"" + option.get(key) + "\"";
					}
				}
				if (value.equals(itemValue)) {
					inp += "<option " + items + " selected=\"selected\"  >" + optionName + "</option>";
				} else {
					inp += "<option " + items + " >" + optionName + "</option>";
				}
	
			}
		}
		return Html.apply(inp);
	}
	
	/*public static Html addSelectList(String name, List<HashMap<String, String>> options, String header, HashMap<String, String> attrList, HashMap<String, String> value) {

		String attr = addAttribute(attrList);
		String inp = "<select   name=\"" + name + "\" id=\"" + name + "\"" + attr + " />";
		if (header != null) {
			inp += "<option value=\"\" >" + header + "</option>";
		}
		HashMap<String, String> option = null;
		for (int i = 0; i < options.size(); i++) {
			option = options.get(i);
			String items = "";
			String optionName = "";
			optionName = option.get("name");
			option.remove("name");
			String itemValue = "";
			if (option != null && !option.isEmpty()) {
				itemValue = option.get("value");
				for (String key : option.keySet()) {
					items += key + " = \"" + option.get(key) + "\"";
				}
			}
			if (value.get(itemValue) != null && value.get(itemValue).equals(itemValue)) {
				inp += "<option " + items + " selected=\"selected\"  >" + optionName + "</option>";
			} else {
				inp += "<option " + items + " >" + optionName + "</option>";
			}

		}

		return Html.apply(inp);
	}

	
	public static Html addSelectList(String name, List<HashMap<String, String>> options, String header, HashMap<String, String> attrList, String value) {
		
		String attr = addAttribute(attrList);
		String inp = "<select  name=\"" + name + "\" id=\"" + name + "\"" + attr + " />";
		if (header != null) {
			inp += "<option value=\"\" >" + header + "</option>";
		}
		HashMap<String, String> option = null;
		for (int i = 0; i < options.size(); i++) {
			option = options.get(i);
			String items = "";
			String optionName = "";
			optionName = option.get("name");
			option.remove("name");
			String itemValue = "";
			if (option != null && !option.isEmpty()) {
				itemValue = option.get("value");
				for (String key : option.keySet()) {
					items += key + " = \"" + option.get(key) + "\"";
				}
			}
			if (value.equals(itemValue)) {
				inp += "<option " + items + " selected=\"selected\"  >" + optionName + "</option>";
			} else {
				inp += "<option " + items + " >" + optionName + "</option>";
			}

		}

		return Html.apply(inp);
	}
	
	*/

	public static Html addTextarea(String name, int rows, int col, String value, HashMap<String, String> attrList) {

		String attr = addAttribute(attrList);
		String inp = "<textarea rows=\"" + String.valueOf(rows) + "\" rows=\"" + String.valueOf(col) + "\"  name=\"" + name + "\" value=\"" + value + "\" " + attr + " >"+value+"</textarea>";

		return Html.apply(inp);
	}

	public static Html addInput(String typeInput, String name, String value, HashMap<String, String> attrList) {

		String attr = addAttribute(attrList);
		String inp = "<input type=\"" + typeInput + "\" name=\"" + name + "\" value=\"" + value + "\" " + attr + " />";

		return Html.apply(inp);
	}

	public static String addAttribute(HashMap<String, String> attrList) {
		String attr = "";
		if (attrList != null && !attrList.isEmpty()) {
			for (String key : attrList.keySet()) {
				attr += key + "=\"" + attrList.get(key) + "\" ";
			}
		}
		return attr;
	}

}
