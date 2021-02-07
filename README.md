# Parking-lot-Service
	Problem: Implement Parking lot Service using micro-service architecture

#Steps to deploy:
	Step 1: Run "git clone https://github.com/bhuvanp1305/Parking-lot.git" and 
				run Step 2 to 4 inside of Cloned Parking-lot project
	Step 2: Run "chmod +x mvnw mvnw.cmd"
	Step 3: Run "docker build -t parking-app-server"
	Step 4: Run "docker-compose up"
	Step 5: Add at-least 3 Parking slots one by one (e.g. Parking 1, Parking 2, Parking 3 ....):
			URL: 
					localhost:8080/parking-lot/addSlot
			Request Method: POST
			Request Body	:
					{
						"name": "Parking 1"
	    			}
		    			
		   or Run below SQL query in db
			   INSERT INTO `parking_lot`.`parking_slot`(`parking_id`,`name`) VALUES (1,"Parking 1");
				INSERT INTO `parking_lot`.`parking_slot`(`parking_id`,`name`) VALUES (2,"Parking 2");
				INSERT INTO `parking_lot`.`parking_slot`(`parking_id`,`name`) VALUES (3,"Parking 3");
#End Points to assign a free slot and exit from the parking
		 Use below URLs for Parking
			Car Entry: 
				URL: localhost:8080/parking-lot/entry
				Request Method: POST
				Request Body	:
						{
						    "name": "MP 09 UW 0001"
						}
			
			Car Exit: 
				URL: localhost:8080/parking-lot/exit
				Request Method: POST
				Request Body	:
						{
						    "name": "MP 09 UW 0001"
						}