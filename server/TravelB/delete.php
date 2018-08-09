 <?php
        include 'config.php';
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        //Insert Query
        $result = mysqli_query($conn, "DELETE FROM
        `mad_fandy`.`contact`
        WHERE id = '".$obj->{'id'}."'");
        $conn->close();
          if($result) {
             echo json_encode(array('posts'=>array("Success")));
          } else {
             echo json_encode(array('posts'=>array("Fail")));
} ?>