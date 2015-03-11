(function () {

    var Surface = famous.core.Surface;
    var Modifier = famous.core.Modifier;
    var SequentialLayout = famous.views.SequentialLayout;
    var RenderNode = famous.core.RenderNode;
    var Timer = famous.utilities.Timer;
    var Transitionable = famous.transitions.Transitionable;
    var Engine = famous.core.Engine;
    
    var CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()][{}\\/<>,.0123456789";
    var NUM_COLUMNS = 100;
    var NUM_ROWS = 60;
    
    console.log("The matrix has you.");
    var ctx = Engine.createContext();
    addMatrix(ctx);

    function addMatrix(ctx) {
	var positionModifier = new Modifier({
	    origin: [0, 0],
	    align: [0, 0]
	});
	var layout = new SequentialLayout({
	    direction: 0
	});
	var columns = [];
	layout.sequenceFrom(columns);
	for (var i = 0; i < NUM_COLUMNS; i++) {
	    columns.push(makeColumn());
	}
	ctx.add(layout);
    }

    function makeColumn() {
	var layout = new SequentialLayout();
	var characters = [];
	var resetFunctions = [];
	var i = 0;
	var period = Math.random() * 300;
	layout.sequenceFrom(characters);
	Timer.setInterval(function characterReset() {
	    var idx = i % NUM_ROWS;
	    if (i < NUM_ROWS) {
		var obj = newCharacter();
		characters.push(obj.renderNode);
		resetFunctions.push(obj.resetFunction);
	    } else {
		resetFunctions[idx]();
	    }
	    i = i + 1;
	}, period);
	return layout;
    }
    
    function newCharacter() {
	var node = new RenderNode();
	var opacityState = new Transitionable();
	var modifier = new Modifier({
	    opacity: function getOpacity() {
		return opacityState.get();
	    }
	});
	var charSurface = new Surface({
	    size: [12, 10],
	    properties: {
		backgroundColor: "#000000",
		lineHeight: "8px",
		fontWeight: "bold",
		fontSize: "0.8em",
		color: "#33FF00"
	    }
	});
	node.add(modifier).add(charSurface);
	function resetFunction() {
	    charSurface.setContent(randomCharacter());
	    opacityState.set(1);
	    var timeout = Math.random() * 200;
	    Timer.setTimeout(function () {
		opacityState.set(0.1, {
		    duration: 1000
		});
		}, timeout);
	    
	};
	resetFunction();
	return {
	    renderNode: node,
	    resetFunction: resetFunction
	};
    }

    function randomCharacter() {
	var n = Math.floor(Math.random() * CHARSET.length);
	return CHARSET.charAt(n);
    };

})();
