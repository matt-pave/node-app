# resource "google_filestore_instance" "instance" {
#   name = "node-app-instance"
#   zone = "us-central1-a"
#   tier = "PREMIUM"

#   file_shares {
#     capacity_gb = 2560
#     name        = "node-app"
#   }

#   networks {
#     network = "default"
#     modes   = ["MODE_IPV4"]
#   }
# }