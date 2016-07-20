package com.ctrip.framework.apollo.biz.service;

import com.google.common.collect.Lists;

import com.ctrip.framework.apollo.biz.entity.ReleaseMessage;
import com.ctrip.framework.apollo.biz.repository.ReleaseMessageRepository;
import com.dianping.cat.Cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Service
public class ReleaseMessageService {
  @Autowired
  private ReleaseMessageRepository releaseMessageRepository;

  public ReleaseMessage findLatestReleaseMessageForMessages(Collection<String> messages) {
    return releaseMessageRepository.findTopByMessageInOrderByIdDesc(messages);
  }

  public List<ReleaseMessage> findLatestReleaseMessagesGroupByMessages(Collection<String> messages) {
    List<Object[]> result =
        releaseMessageRepository.findLatestReleaseMessagesGroupByMessages(messages);
    List<ReleaseMessage> releaseMessages = Lists.newArrayList();
    for (Object[] o : result) {
      try {
        ReleaseMessage releaseMessage = new ReleaseMessage((String) o[0]);
        releaseMessage.setId((Long) o[1]);
        releaseMessages.add(releaseMessage);
      } catch (Exception ex) {
        Cat.logError("Parsing LatestReleaseMessagesGroupByMessages failed", ex);
      }
    }
    return releaseMessages;
  }
}