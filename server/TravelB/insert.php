<?php
    include 'config.php';
    $json = file_get_contents('php://input');
    $obj = json_decode($json);
    //Insert Query
    $result = mysqli_query($conn, "INSERT INTO
    `travelb`.`member` (nohp, pass, nama, alamat)
    VALUES ('".$obj->{'nohp'}."', '".$obj->{'pass'}."', '".$obj->{'nama'}."', '".$obj->{'alamat'}."')");
    $conn->close();
      if($result) {
          echo json_encode(array('posts'=>array("fandy ganteng")));
      } else {
          echo json_encode(array('posts'=>array("Fail")));
} ?>
