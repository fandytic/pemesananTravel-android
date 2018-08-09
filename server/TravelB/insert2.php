<?php
    include 'config.php';
    $json = file_get_contents('php://input');
    $obj = json_decode($json);
    //Insert Query
    $result = mysqli_query($conn, "INSERT INTO
    `travelb`.`pesanan` (nohp, nama, alamat, jumlah, duduk, jam)
    VALUES ('".$obj->{'nohp'}."', '".$obj->{'nama'}."', '".$obj->{'alamat'}."', '".$obj->{'jumlah'}."', '".$obj->{'duduk'}."', '".$obj->{'jam'}."')");
    $conn->close();
      if($result) {
          echo json_encode(array('posts'=>array("fandy ganteng")));
      } else {
          echo json_encode(array('posts'=>array("Fail")));
} ?>
