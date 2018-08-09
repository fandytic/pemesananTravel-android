 <?php
   include 'config.php';
   $json = file_get_contents('php://input');
   $obj = json_decode($json);
   //Insert Query
   $result = mysqli_query($conn, "UPDATE
   `mad_fandy`.`contact`
   SET name = '".$obj->{'name'}."', email = '".$obj->{'email'}."', mobile = '".$obj->{'mobile'}."' WHERE id = '".$obj->{'id'}."'");
   $conn->close();
     if($result) {
      echo json_encode(array('posts'=>array("fandy ganteng")));
         } else {
             echo json_encode(array('posts'=>array("Fail")));
         }
?>
