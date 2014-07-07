$("#candidates").submit(function(event){
	alert("Submitted vote: " + nameMap[$('input[name="candidate"]:checked').val()]);
})

var nameMap = {
	trevorjones: "Trevor Jones",
	stevenharper: "Steven Harper",
	philkessel: "Phil Kessel",
	kylelowry: "Kyle Lowry"
}