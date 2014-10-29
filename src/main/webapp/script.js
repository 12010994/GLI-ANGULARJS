
function GetEventsCtrlAjax($scope, $http)
{
	$http({method: 'GET', url: '/rest/events'}).success(function(data) {
		$scope.events = data;
	});
}

function SendCtrlAjax($scope, $log, $http)
{

	$scope.addEvent = function addEvent(){
		$log.error("addEvent() called");
		$scope.event = {};
		$scope.event.place = "Paris";
		$scope.event.date = "10-10-10";
		$http.post('/rest/addEvent', $scope.event);
		console.log("test console.log");
	}
	$scope.addCar = function addCar(){
		$scope.car = 3;
		$scope.nbSeat = 4;
		$http.post('/rest/addCar', $scope.car).error(function(data) {
			$log.error("addCar() failed");
		}).success(function(data) {
			$log.error("addCar() passed");
		});
	}
}