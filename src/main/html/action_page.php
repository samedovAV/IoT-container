<html>
<body>

<?php

$queryParams = [
'clientKeys' => [attribute1, attribute2],
'sharedKeys' => [shared1, shared2]
];

$url = 'http://demo.thingsboard.io/api/v1/ltX7U9qMMxHiBVax3tP5/attributes?' . http_build_query($queryParams);

 $curl = curl_init();
        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
            $result = curl_exec($curl);
            if($result == false)
            {
              echo "Ошибка CURL: " . curl_error($curl);
              return false;
            }
            else
            {
              $jsonArrayResponse = json_decode($result);
              echo $jsonArrayResponse;
            }


</body>
</html>