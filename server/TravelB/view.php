
   <?php
   include 'config.php';
   include 'contact.php';
   $return_arr = array();
   $fetch = mysqli_query($conn, "SELECT * FROM contact");
   if ($fetch->num_rows > 0) {
          while($row = mysqli_fetch_assoc($fetch)) {
                 $c = new Contact();
                 $c->id = $row['id'];
                 $c->name = $row['name'];
                 $c->email = $row['email'];
                 $c->mobile = $row['mobile'];
                 array_push($return_arr, $c);
               } } else {

          array_push($return_arr, 'No Data');
   }
   $conn->close();
   echo json_encode(array('contact' => $return_arr));
   ?>