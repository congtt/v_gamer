(function () {
    // Private function
    function getColumnsForScaffolding(data) {
        if ((typeof data.length !== 'number') || data.length === 0) {
            return [];
        }
        var columns = [];
        for (var propertyName in data[0]) {
            columns.push({ headerText: propertyName, rowText: propertyName });
        }
        return columns;
    }
	
	function countTotal(data) {
		return data.length || 0;
	}

    ko.simpleGrid = {
        // Defines a view model class you can use to populate a grid
        viewModel: function (configuration) {
            this.data = configuration.data;

			this.totalrow = countTotal(ko.utils.unwrapObservable(this.data));
			
			this.testlist = ko.observableArray([{ name: "10", value: 10 }, { name: "20", value: 20 }, { name: "50", value: 50 }, { name: "100", value: 100 }]);
			
            this.currentPageIndex = ko.observable(0);
            //this.pageSize = configuration.pageSize || 5;
            this.pageSize = ko.observable(configuration.pageSize);
			
            // If you don't specify columns configuration, we'll use scaffolding
            this.columns = configuration.columns || getColumnsForScaffolding(ko.utils.unwrapObservable(this.data));
			
			//console.log(this.columns);
			//this.columns.push({headerText: "blabla", rowText: "stt"});

            this.itemsOnCurrentPage = ko.computed(function () {
                var startIndex = this.pageSize() * this.currentPageIndex();
                return this.data.slice(startIndex, startIndex + this.pageSize());
            }, this);

            this.maxPageIndex = ko.computed(function () {
                return Math.ceil(ko.utils.unwrapObservable(this.data).length / this.pageSize()) - 1;
            }, this);
        }
    };

    // Templates used to render the grid
    var templateEngine = new ko.nativeTemplateEngine();

    templateEngine.addTemplate = function(templateName, templateMarkup) {
        document.write("<script type='text/html' id='" + templateName + "'>" + templateMarkup + "<" + "/script>");
    };
	
	templateEngine.addTemplate("ko_simpleGrid_pageSize", "\
					<div style=\"width:100%; height:25px\">\
						<div style=\"width:50%; float:left; padding-top:5px;\">\
							Tổng số dòng: <span id=\"totalrow\" data-bind=\"text: totalrow\"></span>\
						</div>\
						<div style=\"width:50%; float:left; text-align:right;\">\
							Số dòng/trang \
							<select data-bind=\"\
								options: testlist,\
								optionsText: 'name',\
								optionsValue: 'value',\
								value: pageSize\"></select>\
						</div>\
					</div>\
							");
    templateEngine.addTemplate("ko_simpleGrid_grid", "\
                    <table class=\"ko-grid\" cellspacing=\"0\">\
                        <thead>\
                            <tr data-bind=\"foreach: columns\">\
                               <th data-bind=\"text: headerText\"></th>\
                            </tr>\
                        </thead>\
                        <tbody data-bind=\"foreach: itemsOnCurrentPage\">\
                           <tr data-bind=\"foreach: $parent.columns\">\
                               <td data-bind=\"text: typeof rowText == 'function' ? rowText($parent) : $parent[rowText] \"></td>\
                            </tr>\
                        </tbody>\
                    </table>");
    templateEngine.addTemplate("ko_simpleGrid_pageLinks", "\
                    <div class=\"ko-grid-pageLinks\">\
                        <span>Trang:</span>\
                        <!-- ko foreach: ko.utils.range(0, maxPageIndex) -->\
                               <a href=\"#\" data-bind=\"text: $data + 1, click: function() { $root.currentPageIndex($data) }, css: { selected: $data == $root.currentPageIndex() }\">\
                            </a>\
                        <!-- /ko -->\
                    </div>");

    // The "simpleGrid" binding
    ko.bindingHandlers.simpleGrid = {
        init: function() {
            return { 'controlsDescendantBindings': true };
        },
        // This method is called to initialize the node, and will also be called again if you change what the grid is bound to
        update: function (element, viewModelAccessor, allBindingsAccessor) {
            var viewModel = viewModelAccessor(), allBindings = allBindingsAccessor();

            // Empty the element
            while(element.firstChild)
                ko.removeNode(element.firstChild);

            // Allow the default templates to be overridden
            var gridTemplateName      = allBindings.simpleGridTemplate || "ko_simpleGrid_grid",
                pageLinksTemplateName = allBindings.simpleGridPagerTemplate || "ko_simpleGrid_pageLinks";
			
			var pagesizeTemplateName  = allBindings.simpleGridPagesizeTemplate || "ko_simpleGrid_pageSize";
			
			// TungDQ - render the pagesize
			var gridContainer = element.appendChild(document.createElement("DIV"));
            ko.renderTemplate(pagesizeTemplateName, viewModel, { templateEngine: templateEngine }, gridContainer, "replaceNode");

            // Render the main grid
            var gridContainer = element.appendChild(document.createElement("DIV"));
            ko.renderTemplate(gridTemplateName, viewModel, { templateEngine: templateEngine }, gridContainer, "replaceNode");

            // Render the page links
            var pageLinksContainer = element.appendChild(document.createElement("DIV"));
            ko.renderTemplate(pageLinksTemplateName, viewModel, { templateEngine: templateEngine }, pageLinksContainer, "replaceNode");
        }
    };
})();