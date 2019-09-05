#!/usr/bin/env fish

function access_gateway
  argparse -n access_gateway 'h/help' 't/target=' -- $argv
  or return 1

  if set -lq _flag_help
    echo "access-gateway.fish -t/--target <get/post>"
    return
  end

  set -lq _flag_target
  or set -l _flag_target get

  curl -X GET http://localhost:8080/$_flag_target
end

access_gateway $argv
